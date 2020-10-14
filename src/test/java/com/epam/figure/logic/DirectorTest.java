package com.epam.figure.logic;

import com.epam.figure.dao.DaoException;
import com.epam.figure.dao.DaoFactory;
import com.epam.figure.dao.DataDao;
import com.epam.figure.entity.Cube;
import com.epam.figure.entity.Point;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(DataProviderRunner.class)
public class DirectorTest {

    @DataProvider
    public static Object[][] testProvider(){

        Object[][] objects = {
                {Arrays.asList("AX=0; AY=0; AZ=0; BX=1; BY=0; BZ=0; CX=1; CY=1; CZ=0; " +
                        "DX=0; DY=1; DZ=0; AX1=0; AY1=0; AZ1=1; BX1=1; BY1=0; BZ1=1; " +
                        "CX1=1; CY1=1; CZ1=1; DX1=0; DY1=1; DZ1=1"),
                        Arrays.asList(new Cube(Arrays.asList(new Point(0, 0, 0),
                                new Point(1, 0, 0),
                                new Point(1, 1, 0),
                                new Point(0, 1, 0),
                                new Point(0, 0, 1),
                                new Point(1, 0, 1),
                                new Point(1, 1, 1),
                                new Point(0, 1, 1))))}
        };
        return objects;
    }


    @Test
    @UseDataProvider("testProvider")
    public void testListCubeAfterValidationShouldPutRightData(List<String> inPut, List<Cube> outPut){
        Director director = new Director();
        List<Cube> cubes = director.listCubeAfterValidation(inPut);

        Assert.assertEquals(cubes, outPut);
    }


    @Test
    public void testStartSystem() throws DaoException{
        DaoFactory daoFactory = DaoFactory.getInstance();
        DataDao dataDao = Mockito.mock(DataDao.class);
        when(dataDao.readData()).thenReturn(anyList());

        List<String> listData = dataDao.readData();

        Assert.assertNotNull(listData);
    }
}
