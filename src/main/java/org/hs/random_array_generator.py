import random

def generate_random_numbers(min_value, max_value, number_of_numbers):
    random_numbers = []
    for i in range(number_of_numbers):
        random_numbers.append(random.randint(min_value, max_value))

    return random_numbers

random_numbers = generate_random_numbers(-5000, 5000, 100)
filename = "test.txt"

f = open(filename, "w")
for i in range(len(random_numbers)-1):
  f.write(f"{random_numbers[i]},")
f.write(f"{random_numbers[len(random_numbers)-1]}")
