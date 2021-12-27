from concurrent import futures
import grpc
import led_control_pb2
import led_control_pb2_grpc
import google
import traceback

import board
import neopixel

class LedMatrix:
    def __init__(self, width, height):
        self.data = [Color(0, 0, 0)] * (width * height)
        self.width = width
        self.height = height

    def get(self, row, col):
        return self.data[self.width * row + col]

    def set(self, row, col, color):
        self.data[self.width * row + col] = color

class LedMapping:
    def __init__(self):
        self.data = {}

    def set(self, row, col, index):
        self.data[(row, col)] = index

    def get(self, row, col):
        return self.data[(row, col)]

class Color:
    def __init__(self, r, g, b):
        self.r = r
        self.g = g
        self.b = b

    def tuple(self):
        return (self.r, self.g, self.b)

    @classmethod
    def fromInt(self, i):
        mask = 0xFF
        return Color(
            (i >> 16) & mask,
            (i >> 8) & mask,
            (i >> 0) & mask
        )

    def __str__(self):
        return "(%d, %d, %d)" % (self.r, self.g, self.b)


class LedControl(led_control_pb2_grpc.LedControlServicer):

    # def mapToIntArray(self, byteString):
    #     out = [0] * int(len(byteString) / 4)

    #     for i in range(len(out)):
    #         # little endian
    #         num =                               \
    #             (byteString[(i*4)+0] << 0) |    \
    #             (byteString[(i*4)+1] << 8) |    \
    #             (byteString[(i*4)+2] << 16) |   \
    #             (byteString[(i*4)+3] << 24)
    #         out[i] = num

    #     return out

    def ledDataToMatrix(self, ledData):
        # intArray = self.mapToIntArray(request.data)
        matrix = LedMatrix(ledData.width, ledData.height)

        for y in range(ledData.height):
            for x in range(ledData.width):
                i = y * ledData.height + x
                color = Color.fromInt(ledData.data[i])
                matrix.set(y, x, color)

        return matrix

    def mappingToLedMapping(self, mapping):
        ledMapping = LedMapping()
        data = mapping.data

        assert len(data) % 3 == 0

        for i in range(int(len(data) / 3)):
            ledMapping.set(data[i * 3 + 0], data[i * 3 + 1], data[i * 3 + 2])

        return ledMapping

    def write(self):
        for r in range(self.matrix.height):
            for c in range(self.matrix.width):
                idx = self.mapping.get(r, c)
                self.pixels[idx] = self.matrix.get(r, c).tuple()

        self.pixels.write()

    def Initialize(self, request, context):
        self.matrix = self.ledDataToMatrix(request.ledData)
        self.mapping = self.mappingToLedMapping(request.mapping)

        try:
            self.pixels = neopixel.NeoPixel(
                board.D18,
                self.matrix.width * self.matrix.height,
                auto_write=False,
                pixel_order = neopixel.GRB
            )
            self.write()

            return google.protobuf.wrappers_pb2.BoolValue(value=True)

        except:
            traceback.print_exc()
            return google.protobuf.wrappers_pb2.BoolValue(value=False)


    def WriteData(self, request, context):
        self.matrix = self.ledDataToMatrix(request)
        self.write()

        return google.protobuf.empty_pb2.Empty()

def main():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    led_control_pb2_grpc.add_LedControlServicer_to_server(LedControl(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    print("Running")
    server.wait_for_termination()

if __name__ == "__main__":
    main()
