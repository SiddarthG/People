package com.hackerearth.sid.people;

/**
 * Created by sid on 10/25/2015.
 */
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sid on 10/18/2015.
 */
public class DataSet implements Serializable {

    Date dob;
    String status;
    String image;
    String ethnicity;
    int weight;
    int height;
    boolean is_veg;
    boolean drink;

    public DataSet() {
        //data="N/A";
    }

    public DataSet(Date dob,String status, String image, int ethnicity, int weight, int height, boolean is_veg, boolean drink) {
        this.dob=dob;
        this.status = status;
        this.image = image;
        this.ethnicity = parse(ethnicity);
        this.weight = weight;
        this.height = height;
        this.is_veg = is_veg;
        this.drink = drink;


    }

    public String parse(int v) {
        switch (v) {
            case 0:
                return "Asian";


            case 1:
                return "Indian";

            case 2:
                return "African Americans";

            case 3:
                return "Asian Americans";

            case 4:
                return "European";

            case 5:
                return "British";

            case 6:
                return "Jewish";

            case 7:
                return "Latino";

            case 8:
                return "Native American";


            case 9:
                return "Arabic";


        }
       return "Asian";

    }
}