import request from '@/utils/request'

// 查询课程安排列表
export function listArrange(query) {
  return request({
    url: '/community/arrange/list',
    method: 'get',
    params: query
  })
}

// 查询课程安排详细
export function getArrange(arrangeId) {
  return request({
    url: '/community/arrange/' + arrangeId,
    method: 'get'
  })
}

// 新增课程安排
export function addArrange(data) {
  return request({
    url: '/community/arrange',
    method: 'post',
    data: data
  })
}

// 修改课程安排
export function updateArrange(data) {
  return request({
    url: '/community/arrange',
    method: 'put',
    data: data
  })
}

// 删除课程安排
export function delArrange(arrangeId) {
  return request({
    url: '/community/arrange/' + arrangeId,
    method: 'delete'
  })
}

// 导出课程安排
export function exportArrange(query) {
  return request({
    url: '/community/arrange/export',
    method: 'get',
    params: query
  })
}