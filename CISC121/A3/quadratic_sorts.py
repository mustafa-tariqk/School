""" This program contains functions that sort lists while recording
their performance.

Author: Mustafa Tariq
Student Number: 20212856
Section: 001
Date:2020-11-18
"""


def insertion(a_list):
    """ Sorts a list using insertion sort while counting how many outer loops,
     inner loops and swaps.
    """
    outer_loops = 0
    inner_loops = 0
    num_swaps = 0
    a = list(a_list)  # Alias used so list doesn't stay sorted.

    for key in range(1, len(a)):
        outer_loops += 1
        i = key
        while i > 0 and a[i-1] > a[i]:
            inner_loops += 1
            a[i-1], a[i] = a[i], a[i-1]
            num_swaps += 1
            i -= 1

    return outer_loops, inner_loops, num_swaps


def selection(a_list):
    """ Sorts a list using selection sort while counting how many outer loops,
     inner loops and swaps.
    """
    outer_loops = 0
    inner_loops = 0
    num_swaps = 0
    a = list(a_list)

    n = len(a)
    for i in range(n):
        outer_loops += 1
        current_min = i
        for j in range(i+1, n):
            inner_loops += 1
            if a[current_min] > a[j]:
                current_min = j
        a[i], a[current_min] = a[current_min], a[i]
        num_swaps += 1

    return outer_loops, inner_loops, num_swaps


def bubble(a_list):
    """ Sorts a list using bubble sort while counting how many outer loops,
     inner loops and swaps.
    """
    outer_loops = 0
    inner_loops = 0
    num_swaps = 0
    a = list(a_list)

    n = len(a)
    for i in range(n):
        outer_loops += 1
        for j in range(0, n-i-1):
            inner_loops += 1
            if a[j] > a[j+1]:
                a[j], a[j+1] = a[j+1], a[j]
                num_swaps += 1

    return outer_loops, inner_loops, num_swaps


if __name__ == "__main__":
    best = [2.61716856426196, 5.915888640615756, 7.083422291608406, 8.726369058089489, 9.008100186993472]
    worst = [8.446986266915214, 4.266319822227643, 2.6602082223312298, 2.127678433877384, 1.2233535181237896]
    rand = [5.610284227291091, 6.836574614181809, 2.6909325116300153, 6.755964711962904, 5.335545671292289]

    # Checks if counters work for all sorting algorithms
    print(insertion(best))
    print(insertion(worst))
    print(insertion(rand))
    print()

    print(selection(best))
    print(selection(worst))
    print(selection(rand))
    print()

    print(bubble(best))
    print(bubble(worst))
    print(bubble(rand))
