package com.epam.figure.logic;

import com.epam.figure.dao.DaoException;
import com.epam.figure.dao.DaoFactory;
import com.epam.figure.dao.DataDao;
import com.epam.figure.entity.Cube;
import com.epam.figure.entity.Points;
import com.epam.figure.validation.ValidatorCube;
import com.epam.figure.validation.ValidatorData;
import com.epam.figure.validation.ValidatorDataFile;
import com.epam.figure.validation.ValidatorFigure;

import java.util.ArrayList;
import java.util.List;

public class Director {

    public void startSystem() throws DaoException{
        DaoFactory daoFactory = DaoFactory.getInstance();
        DataDao dataDao = daoFactory.getDataDao();
        List<String> listData = dataDao.readData();

        List<Cube> cubes = listCubeAfterValidation(listData);

        calculateOperations(cubes);
    }

    public List<Cube> listCubeAfterValidation(List<String> list){
        List<Cube> cubes = new ArrayList<>();
        ParserStringData parserStringData = new ParserStringData();
        ValidatorData validatorData = new ValidatorDataFile();
        ValidatorFigure validatorFigure = new ValidatorCube();
        for (String s : list) {
            List<String> listAfterParse = parserStringData.parseLines(s);
            if (validatorData.checkData(listAfterParse)) {
                Points points = new Points(parserStringData.parseLinesToPoints(listAfterParse));
                if (validatorFigure.checkFigure(points.getPoints())) {
                    cubes.add(new Cube(points.getPoints()));
                }
            }
        }
        return cubes;
    }

    public void calculateOperations(List<Cube> cubes){
        Calculator calculator = new Calculator();
        for (Cube c : cubes) {
            calculator.surfaceArea(c);
            calculator.volume(c);
            calculator.volumeRatio(c, "xy");
            calculator.volumeRatio(c, "xz");
            calculator.volumeRatio(c, "yz");
        }
    }
}
