// Databricks notebook source
case class MyCaseClass(key: String, group: String, value: Int)
val dataframe = sc.parallelize(Array(MyCaseClass("f", "consonants", 1),
       MyCaseClass("g", "consonants", 2),
       MyCaseClass("h", "consonants", 3),
       MyCaseClass("i", "vowels", 4),
       MyCaseClass("j", "consonants", 5))
).toDF()

//dataframe.show

// COMMAND ----------

display(dataframe)

// COMMAND ----------

case class SalesEntry(category: String, product: String, year: Int, salesAmount: Double)
val salesEntryDataFrame = sc.parallelize(
  SalesEntry("fruits_and_vegetables", "apples", 2012, 100.50) :: 
  SalesEntry("fruits_and_vegetables", "oranges", 2012, 100.75) :: 
  SalesEntry("fruits_and_vegetables", "apples", 2013, 200.25) :: 
  SalesEntry("fruits_and_vegetables", "oranges", 2013, 300.65) :: 
  SalesEntry("fruits_and_vegetables", "apples", 2014, 300.65) :: 
  SalesEntry("fruits_and_vegetables", "oranges", 2015, 100.35) ::
  SalesEntry("butcher_shop", "beef", 2012, 200.50) :: 
  SalesEntry("butcher_shop", "chicken", 2012, 200.75) :: 
  SalesEntry("butcher_shop", "pork", 2013, 400.25) :: 
  SalesEntry("butcher_shop", "beef", 2013, 600.65) :: 
  SalesEntry("butcher_shop", "beef", 2014, 600.65) :: 
  SalesEntry("butcher_shop", "chicken", 2015, 200.35) ::
  SalesEntry("misc", "gum", 2012, 400.50) :: 
  SalesEntry("misc", "cleaning_supplies", 2012, 400.75) :: 
  SalesEntry("misc", "greeting_cards", 2013, 800.25) :: 
  SalesEntry("misc", "kitchen_utensils", 2013, 1200.65) :: 
  SalesEntry("misc", "cleaning_supplies", 2014, 1200.65) :: 
  SalesEntry("misc", "cleaning_supplies", 2015, 400.35) ::
  Nil).toDF()
display(salesEntryDataFrame)