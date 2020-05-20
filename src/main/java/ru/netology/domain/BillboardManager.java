package ru.netology.domain;

public class BillboardManager {
    Film[] films = {new Film(1, "Call of the ancestors", "action"),
            new Film(2, "Forward", "action"),
            new Film(3, "Green mile", "drama"),
            new Film(4, "Capernaum", "drama"),
            new Film(5, "Beginning", "fantastic"),
            new Film(6, "Avatar", "fantastic"),
            new Film(7, "Howl's moving castle", "fantastic"),
            new Film(8, "Diamond hand", "comedy"),
            new Film(9, "Good luck gentlemen", "comedy"),
            new Film(10, "Serf", "comedy")};

    private int howManyFilmsToShow;
    int show = 10;
    public BillboardManager(int howManyFilmsToShow) {

        if (howManyFilmsToShow > 0 & howManyFilmsToShow < 10) {
            show = howManyFilmsToShow;
        }
    }


    public void addFilm(Film film) {
        int filmsLength = films.length;
        Film[] tmpArray = new Film[filmsLength + 1];
        System.arraycopy(films, 0, tmpArray, 0, filmsLength);
        int lastIndex = tmpArray.length - 1;
        tmpArray[lastIndex] = film;
        films = tmpArray;
    }

    public Film[] getLastAdded() {
        int filmsLength = films.length;
        Film[] customFilm = new Film[show];
        for (int current = 0; current < customFilm.length; current++) {
            int result = filmsLength - current - 1;
            customFilm[current] = films[result];
        }
        return customFilm;
    }
}