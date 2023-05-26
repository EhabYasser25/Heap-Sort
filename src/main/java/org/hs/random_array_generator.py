import random
import matplotlib.pyplot as plt


def generate_random_numbers(min_value, max_value, number_of_numbers):
    random_numbers = []
    for i in range(number_of_numbers):
        random_numbers.append(random.randint(min_value, max_value))

    return random_numbers


def best_case(min_value, number_of_numbers):
    numbers = []
    number = min_value
    for i in range(number_of_numbers):
        numbers.append(number + 1)
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


whole_generation()
