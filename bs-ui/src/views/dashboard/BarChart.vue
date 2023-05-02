<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme
import resize from './mixins/resize'
import {clockinCount} from "@/api/community/clockin";
const animationDuration = 6000

export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '300px'
    }
  },
  data() {
    return {
      chart: null,
      datas:[],
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart()
    })
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons');
      let that= this
      clockinCount().then((response) => {
        let clockinCount=response.data.clockinCount;
        that.datas[0]=clockinCount.data0;
        that.datas[1]=clockinCount.data1;
        that.datas[2]=clockinCount.data2;
        that.datas[3]=clockinCount.data3;
        that.datas[4]=clockinCount.data4;
        that.datas[5]=clockinCount.data5;
        that.chart.setOption({
            tooltip: {
              trigger: 'axis',
              axisPointer: { // 坐标轴指示器，坐标轴触发有效
                type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
              }
            },
            grid: {
              top: 10,
              left: '2%',
              right: '2%',
              bottom: '3%',
              containLabel: true
            },
            xAxis: [{
              type: 'category',
              data: ['今日', '昨天', '近7天', '近30天', '本月', '上一月'],
              axisTick: {
                alignWithLabel: true
              }
            }],
            yAxis: [{
              type: 'value',
              axisTick: {
                show: false
              }
            }],
            series: [{
              name: 'pageA',
              type: 'bar',
              stack: 'vistors',
              barWidth: '60%',
              data: this.datas,
              animationDuration
            }]
          })
      });
    }
  }
}
</script>
