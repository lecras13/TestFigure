package com.epam.figure.entity;

import java.util.List;

public class Points {
    private List<Point> points;

    public Points(List<Point> points){
        this.points = points;
    }

    public List<Point> getPoints(){
        return points;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (!(o instanceof Points)) {
            return false;
        }

        Points points1 = (Points) o;

        return points != null ? points.equals(points1.points) : points1.points == null;
    }

    @Override
    public int hashCode(){
        return points != null ? points.hashCode() : 0;
    }

    @Override
    public String toString(){
        return "Points{" +
                "points=" + points +
                '}';
    }
}
