package com.example.openappproject

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiCalling.ApiRepository
import com.example.apiCalling.ApiViewModel
import com.example.apiCalling.Data
import com.example.apiCalling.OverallUrlChart
import com.example.apiCalling.ViewModelFactory
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.Utils
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var secondRecyclerView: RecyclerView
    lateinit var lineData : LineDataSet
    lateinit var lineChartView : LineChart
    private val baseUrl = "https://api.inopenapp.com/api/"
    private val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI"

    private val viewModel : ApiViewModel by viewModels{
        ViewModelFactory(ApiRepository(baseUrl,token))
    }
    var dataList = mutableListOf<String>()
    var cardItem = mutableListOf<VerticalRecyclerViewData>()
    var listEntry = arrayListOf<Entry>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.horizontal_recycl_view)
        secondRecyclerView = findViewById(R.id.vertical_recycl_view)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        secondRecyclerView.layoutManager = LinearLayoutManager(this)
        lineChartView = findViewById<LineChart>(R.id.lineChart)

        viewModel.data.observe(this, Observer { response ->
            if (response.isSuccessful) {
                dataList.add(response.body()?.today_clicks.toString())
                dataList.add(response.body()?.topLocation.toString())
                dataList.add(response.body()?.top_source.toString())
                recyclerView.adapter = HorizontalRecyclerView(dataList)
                setDataRecyclerView(response.body()?.data,cardItem)
                secondRecyclerView.adapter = VerticalRecyclerView(cardItem)
                addDataInLineChart(response.body()?.data?.overall_url_chart)
                lineData.notifyDataSetChanged()
                lineChartView.notifyDataSetChanged()
                lineChartView.invalidate()
                Log.d("#OnResult", "onCreate: On Success ${response.body()}")
            } else {
                Log.d("#OnResult", "onCreate: On Fail ${response.body()}")
            }
        })

        viewModel.getData()

    }

    private fun addDataInLineChart(overallUrlChart: OverallUrlChart?) {
        if(overallUrlChart != null) {
            listEntry.add(Entry(0F, overallUrlChart.x0000.toFloat()))
            listEntry.add(Entry(1F, overallUrlChart.x0100.toFloat()))
            listEntry.add(Entry(2F, overallUrlChart.x0200.toFloat()))
            listEntry.add(Entry(3F, overallUrlChart.x0300.toFloat()))
            listEntry.add(Entry(4F, overallUrlChart.x0400.toFloat()))
            listEntry.add(Entry(5F, overallUrlChart.x0500.toFloat()))
            listEntry.add(Entry(6F, overallUrlChart.x0600.toFloat()))
            listEntry.add(Entry(7F, overallUrlChart.x0700.toFloat()))
            listEntry.add(Entry(8F, overallUrlChart.x0800.toFloat()))
            listEntry.add(Entry(9F, overallUrlChart.x0900.toFloat()))
            listEntry.add(Entry(10F, overallUrlChart.x1000.toFloat()))
            listEntry.add(Entry(11F, overallUrlChart.x1100.toFloat()))
            listEntry.add(Entry(12F, overallUrlChart.x1200.toFloat()))
            listEntry.add(Entry(13F, overallUrlChart.x1300.toFloat()))
            listEntry.add(Entry(14F, overallUrlChart.x1400.toFloat()))
            listEntry.add(Entry(15F, overallUrlChart.x1500.toFloat()))
            listEntry.add(Entry(16F, overallUrlChart.x1600.toFloat()))
            listEntry.add(Entry(17F, overallUrlChart.x1700.toFloat()))
            listEntry.add(Entry(18F, overallUrlChart.x1800.toFloat()))
            listEntry.add(Entry(19F, overallUrlChart.x1900.toFloat()))
            listEntry.add(Entry(20F, overallUrlChart.x2000.toFloat()))
            listEntry.add(Entry(21F, overallUrlChart.x2100.toFloat()))
            listEntry.add(Entry(22F, overallUrlChart.x2200.toFloat()))
            listEntry.add(Entry(23F, overallUrlChart.x2300.toFloat()))
        }

        if (lineChartView.data != null) {
            lineData = lineChartView.data.getDataSetByIndex(0) as LineDataSet

            lineData.values = listEntry
            lineChartView.description.isEnabled = false
            val gradient = android.graphics.LinearGradient(
                0f, 600f, 0f, 0f,
                ContextCompat.getColor(this, R.color.backgroundColor),
                ContextCompat.getColor(this, R.color.backgroundColor),
                Shader.TileMode.CLAMP
            )

            val paint = lineChartView.renderer.paintRender
            paint.setShader(gradient)
            lineChartView.data.notifyDataChanged()
            lineData.disableDashedLine()
            lineChartView.notifyDataSetChanged()
        }else {
            lineData = LineDataSet(listEntry, null)
            lineData.setDrawIcons(false)
            lineData.setDrawCircleHole(false)
            lineData.setDrawFilled(true)
            val gradient = android.graphics.LinearGradient(
                0f, 600f, 0f, 0f,
                ContextCompat.getColor(this, R.color.backgroundColor),
                ContextCompat.getColor(this, R.color.backgroundColor),
                Shader.TileMode.CLAMP
            )

            val paint = lineChartView.renderer.paintRender
            paint.setShader(gradient)
            if (Utils.getSDKInt() >= 18) {
                val drawable = ContextCompat.getDrawable(this, R.color.backgroundColor)
                lineData.setFillDrawable(drawable)
            } else {
                lineData.setFillColor(Color.DKGRAY)
            }
            val dataSets = ArrayList<ILineDataSet>()
            dataSets.add(lineData)
            val data = LineData(dataSets)
            lineData.disableDashedLine()
            lineChartView.description.isEnabled = false
            lineChartView.setData(data)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setDataRecyclerView(data: Data?, cardItem: MutableList<VerticalRecyclerViewData>) {
        data?.recent_links?.forEach{recentLink ->
            cardItem.add(VerticalRecyclerViewData(smart_link = recentLink.smartLink.toString(),
                original_link = recentLink.originalImage.toString(), created_At = formatTimestampToIST(recentLink.createdAt),
                total_clicks = recentLink.totalClicks.toString(),
                webLink = recentLink.webLink))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun formatTimestampToIST(timestamp: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")
        val zonedDateTime = ZonedDateTime.parse(timestamp, formatter)
        val istZoneId = ZoneId.of("Asia/Kolkata")
        val istZonedDateTime = zonedDateTime.withZoneSameInstant(istZoneId)
        val outputFormatter = DateTimeFormatter.ofPattern("dd MMM, yyyy")
        return istZonedDateTime.format(outputFormatter)
    }
}