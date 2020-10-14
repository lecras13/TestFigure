package com.epam.figure.entity;

import java.util.List;

public class Cube {
    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private Point a1;
    private Point b1;
    private Point c1;
    private Point d1;

    public Cube(List<Point> points){
        this.a = points.get(0);
        this.b = points.get(1);
        this.c = points.get(2);
        this.d = points.get(3);
        this.a1 = points.get(4);
        this.b1 = points.get(5);
        this.c1 = points.get(6);
        this.d1 = points.get(7);
    }

    public Point getA(){
        return a;
    }

    public Point getB(){
        return b;
    }

    public Point getC(){
        return c;
    }

    public Point getA1(){
        return a1;
    }

    public Point getD(){
        return d;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cube cube = (Cube) o;

        if (a != null ? !a.equals(cube.a) : cube.a != null) {
            return false;
        }
        if (b != null ? !b.equals(cube.b) : cube.b != null) {
            return false;
        }
        if (c != null ? !c.equals(cube.c) : cube.c != null) {
            return false;
        }
        if (d != null ? !d.equals(cube.d) : cube.d != null) {
            return false;
        }
        if (a1 != null ? !a1.equals(cube.a1) : cube.a1 != null) {
            return false;
        }
        if (b1 != null ? !b1.equals(cube.b1) : cube.b1 != null) {
            return false;
        }
        if (c1 != null ? !c1.equals(cube.c1) : cube.c1 != null) {
            return false;
        }
        return d1 != null ? d1.equals(cube.d1) : cube.d1 == null;
    }

    @Override
    public int hashCode(){
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        result = 31 * result + (a1 != null ? a1.hashCode() : 0);
        result = 31 * result + (b1 != null ? b1.hashCode() : 0);
        result = 31 * result + (c1 != null ? c1.hashCode() : 0);
        result = 31 * result + (d1 != null ? d1.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return "Cube{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", a1=" + a1 +
                ", b1=" + b1 +
                ", c1=" + c1 +
                ", d1=" + d1 +
                '}';
    }
}
