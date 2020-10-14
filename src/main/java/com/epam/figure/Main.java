package com.epam.figure;

import com.epam.figure.dao.DaoException;;
import com.epam.figure.logic.Director;

public class Main {

    public static void main(String[] args) throws DaoException{
        Director director = new Director();
        director.startSystem();
    }
}
