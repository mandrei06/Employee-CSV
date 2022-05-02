# Employee-CSV
This program reads employee data from a .csv file and writes it to a MySQL database using multithreading.

# Instructions

Create a MySQL schema and replace db.url in database.properties with the URL of the schema.

# Multithreading
From testing we found:

Threads = 1, Done in 29.2394095 seconds

Threads = 2, Done in 28.0245663 seconds

Threads = 3, Done in 33.3245559 seconds

Threads = 4, Done in 115.1876105 seconds

Threads = 5, Done in 114.1217903 seconds

Threads = 10, Done in 117.9329041 seconds

Threads = 50, Done in 115.2312885 seconds

So this program uses 2 threads by default.
