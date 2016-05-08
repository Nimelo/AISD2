method1 <- function(n = 10000, a = 100) {
    values = rep_len(0, 100)

     for (k in 1:n) {
        k2 = k * k
        c = sqrt(k2 / a)
        x = floor(k2 / c) %% a
        values[x] <- values[x] + 1
    }

    return(values)
}

N = 10000
A = 100


alg <- function() {
    setwd("E:/GitHubRepo/Hashing/")
    file <- read.csv("ceil.csv")
    plot(x = file[, 1], y = file[, 2], type = "s", xlab = "Indeksy w tablicy", ylab = "Ilosc wystapien", col = "red")

    file <- read.csv("floor.csv")
    points(x = file[, 1], y = file[, 2], type = "s", xlab = "Amount of indexes", ylab = "Amount of occurrences", col = "green")

    file <- read.csv("czech.csv")
    points(x = file[, 1], y = file[, 2], type = "s", xlab = "Amount of indexes", ylab = "Amount of occurrences", col = "blue")

    legend(1, 1170, legend = c("Zaok. w gore", "Zaok. w dol", "Suma przesuniec"), col = c("red", "green", "blue"), lty = 1:2, cex = 0.8)
}

alg2 <- function() {
    setwd("E:/GitHubRepo/Hashing/")
    file <- read.csv("AlphabetCeil.csv")
    plot(x = file[, 1], y = file[, 2], type = "s", xlab = "Indeksy w tablicy", ylab = "Ilosc wystapien", col = "red")

    file <- read.csv("AlphabetFloor.csv")
    points(x = file[, 1], y = file[, 2], type = "s", xlab = "Amount of indexes", ylab = "Amount of occurrences", col = "green")

    file <- read.csv("AlphabetCzech.csv")
    points(x = file[, 1], y = file[, 2], type = "s", xlab = "Amount of indexes", ylab = "Amount of occurrences", col = "blue")

    legend(1, 5470, legend = c("Zaok. w gore", "Zaok. w dol", "Suma przesuniec"), col = c("red", "green", "blue"), lty = 1:2, cex = 0.8)
}

alg3 <- function() {
    setwd("E:/GitHubRepo/Hashing/")

    file <- read.csv("AlphabetCzechShift.csv")
    plot(x = file[, 1], y = file[, 2], type = "s", xlab = "Indeksy w tablicy", ylab = "Ilosc wystapien", col = "blue")

    file <- read.csv("AlphabetCeilShift.csv")
    points(x = file[, 1], y = file[, 2], type = "s", xlab = "Amount of indexes", ylab = "Amount of occurrences", col = "red")

    file <- read.csv("AlphabetFloorShift.csv")
    points(x = file[, 1], y = file[, 2], type = "s", xlab = "Amount of indexes", ylab = "Amount of occurrences", col = "green")

    legend(-2, 8200, legend = c("Zaok. w gore", "Zaok. w dol", "Suma przesuniec"), col = c("blue", "red", "green"), lty = 1:2, cex = 0.8)
}

alg4 <- function() {
    setwd("E:/GitHubRepo/Hashing/")

    file <- read.csv("AlphabetCzechXor.csv")
    plot(x = file[, 1], y = file[, 2], type = "s", xlab = "Indeksy w tablicy", ylab = "Ilosc wystapien", col = "red")

    file <- read.csv("AlphabetCzechShiftXor.csv")
    points(x = file[, 1], y = file[, 2], type = "s", xlab = "Amount of indexes", ylab = "Amount of occurrences", col = "red")
}

alg5 <- function() {
    setwd("E:/GitHubRepo/Hashing/")

    file <- read.csv("9.csv")
    plot(x = file[, 1], y = file[, 2], type = "s", xlab = "Indeksy w tablicy", ylab = "Ilosc wystapien", col = "blue")

    file <- read.csv("6.csv")
    points(x = file[, 1], y = file[, 2], type = "s", xlab = "Amount of indexes", ylab = "Amount of occurrences", col = "red")

    file <- read.csv("7.csv")
    points(x = file[, 1], y = file[, 2], type = "s", xlab = "Amount of indexes", ylab = "Amount of occurrences", col = "green")


file <- read.csv("AlphabetCzech.csv")
points(x = file[, 1], y = file[, 2], type = "s", xlab = "Amount of indexes", ylab = "Amount of occurrences", col = "green")


    legend(1, 5470, legend = c("Ceil x^2", "Floor x^2", "Czech"), col = c("red", "green", "blue"), lty = 1:2, cex = 0.8)
}

alg6 <- function() {
    setwd("E:/GitHubRepo/Hashing/")
    file <- read.csv("czech2.csv")
    plot(y = file[, 1], x = file[, 2], type = "s", xlab = "Indeksy w tablicy", ylab = "Ilosc wystapien", col = "blue")

    file2 <- read.csv("czech2standard.csv")
    points(y = file2[, 1], x = file2[, 2], type = "s", xlab = "Indeksy w tablicy", ylab = "Ilosc wystapien", col = "red")


}