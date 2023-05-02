// pages/main/index.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
      dataList:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  dkclick: function (event) {
    let value= event.currentTarget.dataset.value
    let that=this;
    wx.request({
      url: app.globalData.url+'community/clockin',
      method:'post',
      data:{arrangeId:value},
      header:{'Authorization':app.globalData.authorization},
      success(res){
        if(res.data.code==200){
          wx.showToast({
            title: '打卡成功',
            icon: 'none',
            duration: 2000
          }) 
          that.getTodayCourse();
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.getTodayCourse();
  },

  getTodayCourse(){
    let that=this;
    wx.request({
      url: app.globalData.url+'community/arrange/todayCourses',
      method:'get',
      header:{'Authorization':app.globalData.authorization},
      success(res){
        if(res.data.code==200){
          that.setData({
            dataList:res.data.data
          });
          
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})