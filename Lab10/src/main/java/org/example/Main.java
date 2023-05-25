package org.example;


import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;



public class Main {
    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder()
                .appName("RandomSplitExample")
                .master("local[*]")
                .getOrCreate();
// База данных Marijuana Arrests in Toronto: Racial Disparities
// https://www.kaggle.com/datasets/utkarshx27/arrests-for-marijuana-possession
        Dataset<Row> data = spark.read().format("csv")
                .option("header", "true")
                .load("C:\\Users\\artem.zelenskiy\\Downloads\\Arrests.csv");
        data.createOrReplaceTempView("arrests");
        spark.sql("select * from arrests ").show(); // Выводи всю БД
        spark.sql("select * from arrests where year=2000 ").show(); // Выводим всё за 2000 год
        spark.sql("select year, count (*) from arrests group by 1").show(); // Выводи к-во приводов по годам
        spark.sql("select colour, count (*) from arrests group by 1").show(); // К-во приводов по цвету кожи
        spark.sql("select colour, sex, count (*) from arrests group by 1,2 order by 1,2").show(); //К-во приводов по цвету кожи и полу
        spark.sql("select * from arrests where citizen='Yes' ").show(); // Вся БД для жителей
        spark.sql("select year, count (*) as maxi from arrests group by 1 order by 2 desc limit 1").show();//Самый орестуемый год
        spark.sql("select year, colour, sex, count (*) from arrests group by 1,2,3 order by 1,2,3").show(); // агрег по году, цвету и полу
        spark.sql("select year, count(*) from arrests where sex='Male' group by 1 having count(*)>10 ").show();// годы с 11+ приводами
        spark.sql("select * from arrests order by checks desc limit 10").show(); //10 самых опасных людей

        // Останавливаем SparkSession
        spark.stop();



    }
}