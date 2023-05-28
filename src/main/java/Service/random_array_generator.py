import random
import matplotlib.pyplot as plt


def generate_random_numbers(min_value, max_value, number_of_numbers):
    if number_of_numbers > (max_value - min_value + 1):
        raise ValueError("Cannot generate distinct numbers. The range is not large enough.")

    random_numbers = []
    while len(random_numbers) < number_of_numbers:
        new_number = random.randint(min_value, max_value)
        if new_number not in random_numbers:
            random_numbers.append(new_number)

    return random_numbers


def best_case(min_value, number_of_numbers):
    numbers = []
    number = min_value
    for i in range(number_of_numbers):
        numbers.append(number)
        number += 1
    return numbers


def worst_case(max_value, number_of_numbers):
    numbers = []
    number = max_value
    for i in range(number_of_numbers):
        numbers.append(number)
        number -= 1
    return numbers


def generate_best_points(number_of_points):
    for i in range(number_of_points):
        numbers = best_case(-10000, 1000 * (i + 1))
        write_to_file(f"analysis_data/best/{i}.txt", numbers)
        print(f"best {i}")


def generate_worst_points(number_of_points):
    for i in range(number_of_points):
        numbers = worst_case(-10000, 1000 * (i + 1))
        write_to_file(f"analysis_data/worst/{i}.txt", numbers)
        print(f"worst {i}")

def generate_average_points(number_of_points):
    for i in range(number_of_points):
        numbers = generate_random_numbers(-(number_of_points / 2), (number_of_points / 2) - 1, number_of_points)
        write_to_file(f"analysis_data/average/{i}.txt", numbers)
        print(f"average {i}")


def whole_generation():
    generate_best_points(5000)
    generate_worst_points(5000)
    generate_average_points(5000)


def write_to_file(filename, numbers):
    f = open(filename, "w")
    for i in range(len(numbers) - 1):
        f.write(f"{numbers[i]},")
    f.write(f"{numbers[len(numbers) - 1]}")


# whole_generation()
# write_to_file("../Tests/Files/Average_100K.txt", generate_random_numbers(-49999, 49999, 99999))
import random

def shuffle_numbers_in_file(filename):
    with open(filename, 'r') as file:
        numbers = file.readline().strip().split(',')

    random.shuffle(numbers)

    with open(filename, 'w') as file:
        file.write(','.join(numbers))

# Usage example
filename = '../Tests/Files/Average_10M.txt'
shuffle_numbers_in_file(filename)