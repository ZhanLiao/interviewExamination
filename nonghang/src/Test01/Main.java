package Test01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description: 求解B国经过多少年才赶上A国的人均GDP。
 *              输入： A和B国的GDP总数和人口数，以及各自的增长率，并且假设以后每年的增长率都不变。
 * @Date: 2021/6/4 15:16
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        /*double[] a_data = new double[]{21.43, 0.023, 3.28, 0.005};
        double[] b_data = new double[]{14.36, 0.061, 14.0, 0.0033};
        int years = get_year_gra(a_data, b_data);
        System.out.println(years);*/
    }

    private static int get_year_gra(double[] a_data, double[] b_data) {
        int count = 0;
        double diff = 0.0000001;
        double a_gdp = a_data[0];
        double b_gdp = b_data[0];
        double a_people = a_data[2];
        double b_people = b_data[2];
        while (diff > 0){
            count++;
            a_gdp *= (1 + a_data[1]);
            b_gdp *= (1 + b_data[1]);
            a_people *= (1 + a_data[3]);
            b_people *= (1 + b_data[3]);
            diff = a_gdp / a_people - b_gdp / b_people;
        }
        return count;
    }
}
