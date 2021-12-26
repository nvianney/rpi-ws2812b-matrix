from concurrent import futures
import grpc
import led_control_pb2
import led_control_pb2_grpc
import google
import traceback

#import board
#import neopixel

class LedMatrix:
    def __init__(self, width, height):
        self.data = [Color(0, 0, 0)] * (width * height)
        self.width = width
        self.height = height

    def get(self, row, col):
        return self.data[self.width * row + col]

    def set(self, row, col, color):
        self.data[self.width * row + col] = color

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

    def Initialize(self, request, context):
        matrix = self.ledDataToMatrix(request)
        #pixels = neopixel.NeoPixel(board.NEOPIXEL, 10, auto_write=False)


    def WriteData(self, request, context):
        matrix = self.ledDataToMatrix(request)
        print(matrix.get(0, 0))

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
