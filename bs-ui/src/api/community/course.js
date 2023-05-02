import request from '@/utils/request'

// 查询课程信息列表
export function listCourse(query) {
  return request({
    url: '/community/course/list',
    method: 'get',
    params: query
  })
}

// 查询课程信息详细
export function getCourse(courseId) {
  return request({
    url: '/community/course/' + courseId,
    method: 'get'
  })
}

// 新增课程信息
export function addCourse(data) {
  return request({
    url: '/community/course',
    method: 'post',
    data: data
  })
}

// 修改课程信息
export function updateCourse(data) {
  return request({
    url: '/community/course',
    method: 'put',
    data: data
  })
}

// 删除课程信息
export function delCourse(courseId) {
  return request({
    url: '/community/course/' + courseId,
    method: 'delete'
  })
}

// 导出课程信息
export function exportCourse(query) {
  return request({
    url: '/community/course/export',
    method: 'get',
    params: query
  })
}