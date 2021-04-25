""" This program contains functions that do some fun math.

Author: Mustafa Tariq
Student Number: 20212856
Section: 001
Date:2020-10-14
"""


def cal_factorial(x):
    """ Returns factorial of an integer.
    Calculates recursively.
    """
    if x < 2:
        return 1
    else:
        return x * cal_factorial(x - 1)


def list_multiples(number, length):
    """ Returns list of multiples.
    List of multiples of number until length.
    """
    multiples = []
    for i in range(1, length + 1):
        multiples += [number * i]
    return multiples


def find_max(a_list):
    """ Finds the largest element in a list.
    Searching done linearly.
    """
    max = a_list[0]
    for a_value in a_list:
        if max < a_value:
            max = a_value  # Changes value of max if another value is larger.
    return max


if __name__ == "__main__":  # Testing cases for each function

    #  Test cases for cal_factorial(x)
    print(cal_factorial(1))
    print(cal_factorial(2))
    print(cal_factorial(4))
    print(cal_factorial(8))
    print(cal_factorial(16))

    print()

    #  Test cases for list_multiples(number, length)
    print(list_multiples(2, 3))
    print(list_multiples(3, 2))
    print(list_multiples(1, 12))
    print(list_multiples(7, 5))
    print(list_multiples(5, 7))

    print()

    #  Test cases for find_max(a_list)
    print(find_max([1, 3, 4, 2, 1, 3, 4]))
    print(find_max([54, 234, 63, 12, 35, 32, 213]))
    print(find_max([431, 74, 243, 36, 3434, 43]))
    print(find_max([9, 19, 99, 100]))
    print(find_max([436, 34, 12, 54, 2]))
