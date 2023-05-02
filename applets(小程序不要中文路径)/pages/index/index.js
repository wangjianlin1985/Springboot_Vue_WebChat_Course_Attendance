// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    motto: '登 录',
    username: '100000002',
    password: '123456',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    canIUseGetUserProfile: false,
    canIUseOpenData: wx.canIUse('open-data.type.userAvatarUrl') && wx.canIUse('open-data.type.userNickName') // 如需尝试获取用户信息可改为false
  },
  // 事件处理函数
  bindViewTap() {
    wx.navigateTo({
      url: '../login/login'
    })
  },
  onLoad() {
    app.globalData.url="http://127.0.0.1:8080/";
    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
  },
  onSubmit(e) {
    let that =this;
    let param=e.detail.value;
    if(!param.username || param.username.length==0){
      wx.showToast({
        title: '请输入学号',
        icon: 'none',
        duration: 2000
      }) 
      return;
    }

    if(!param.password || param.password.length==0){
      wx.showToast({
        title: '请输入密码',
        icon: 'none',
        duration: 2000
      }) 
      return;
    }

    
    wx.request({
      url: app.globalData.url+'wxlogin',
      data:{username:param.username,password:param.password},
      method:'post',
      success(res){
        if(res.data.code==200){
          app.globalData.authorization="Bearer "+res.data.token;
          wx.switchTab({
            url: '../main/index'
          })
        }
      }
    })
  },
  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    })
  },
  getUserInfo(e) {
    // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
    console.log(e)
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
