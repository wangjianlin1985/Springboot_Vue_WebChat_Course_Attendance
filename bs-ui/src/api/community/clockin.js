import request from '@/utils/request'

// 查询学生考勤列表
export function listClockin(query) {
  return request({
    url: '/community/clockin/list',
    method: 'get',
    params: query
  })
}

// 查询学生考勤列表
export function statisticsIndex() {
  return request({
    url: '/community/clockin/statistics',
    method: 'get'
  })
}

export function clockinCount() {
  return request({
    url: '/community/clockin/clockinCount',
    method: 'get'
  })
}



// 查询学生考勤详细
export function getClockin(clockinId) {
  return request({
    url: '/community/clockin/' + clockinId,
    method: 'get'
  })
}

// 新增学生考勤
export function addClockin(data) {
  return request({
    url: '/community/clockin',
    method: 'post',
    data: data
  })
}

// 修改学生考勤
export function updateClockin(data) {
  return request({
    url: '/community/clockin',
    method: 'put',
    data: data
  })
}

// 删除学生考勤
export function delClockin(clockinId) {
  return request({
    url: '/community/clockin/' + clockinId,
    method: 'delete'
  })
}

// 导出学生考勤
export function exportClockin(query) {
  return request({
    url: '/community/clockin/export',
    method: 'get',
    params: query
  })
}