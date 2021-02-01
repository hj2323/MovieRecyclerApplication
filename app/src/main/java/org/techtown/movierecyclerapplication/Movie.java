package org.techtown.movierecyclerapplication;

import java.io.Serializable;

public class Movie implements Serializable {
    private int imgId;
    private String title;
    private double point;

    public Movie(int imgId, String title, double point) {
        this.imgId = imgId;
        this.title = title;
        this.point = point;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "imgId=" + imgId +
                ", title='" + title + '\'' +
                ", point='" + point + '\'' +
                '}';
    }
}
