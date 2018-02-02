// Databricks notebook source
case class MyCaseClass(key: String, group: String, value: Int)
val dataframe = sc.parallelize(Array(MyCaseClass("f", "consonants", 1),
       MyCaseClass("g", "consonants", 2),
       MyCaseClass("h", "consonants", 3),
       MyCaseClass("i", "vowels", 4),
       MyCaseClass("j", "consonants", 5))
).toDF()

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

// COMMAND ----------

case class WorldEntry(country: String, value: Int)
val world = sc.parallelize(
  WorldEntry("USA", 1000) ::
  WorldEntry("JPN", 23) ::
  WorldEntry("GBR", 23) ::
  WorldEntry("FRA", 21) ::
  WorldEntry("TUR", 3) ::
  Nil).toDF()
display(world)

// COMMAND ----------

val rng = new scala.util.Random(0)
val points = sc.parallelize((0L until 1000L).map { x => (x/100.0, 4 * math.sin(x/100.0) + rng.nextGaussian()) }).toDF()
display(points)

// COMMAND ----------

// MAGIC %r
// MAGIC library(ggplot2)
// MAGIC ggplot(diamonds, aes(carat, price, color = color, group = 1)) + geom_point(alpha = 0.3) + stat_smooth()

// COMMAND ----------

// MAGIC %python
// MAGIC from pyspark.sql import Row
// MAGIC 
// MAGIC array = map(lambda x: Row(key="k_%04d" % x, value = x), range(1, 5001))
// MAGIC largeDataFrame = sqlContext.createDataFrame(sc.parallelize(array))
// MAGIC display(largeDataFrame)

// COMMAND ----------

// MAGIC %python
// MAGIC 
// MAGIC from bokeh.plotting import figure
// MAGIC from bokeh.embed import components, file_html
// MAGIC from bokeh.resources import CDN
// MAGIC 
// MAGIC # prepare some data
// MAGIC x = [1, 2, 3, 4, 5]
// MAGIC y = [6, 7, 2, 4, 5]
// MAGIC 
// MAGIC # create a new plot with a title and axis labels
// MAGIC p = figure(title="simple line example", x_axis_label='x', y_axis_label='y')
// MAGIC 
// MAGIC # add a line renderer with legend and line thickness
// MAGIC p.line(x, y, legend="Temp.", line_width=2)
// MAGIC 
// MAGIC # create an html document that embeds the Bokeh plot
// MAGIC html = file_html(p, CDN, "my plot1")
// MAGIC 
// MAGIC # display this html
// MAGIC displayHTML(html)

// COMMAND ----------

println("hello world")