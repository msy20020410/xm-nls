import axios from 'axios';

// 创建 Axios 实例
const service = axios.create({
    baseURL: 'http://localhost:18000/nls', // 可以配置全局接口前缀
    timeout: 10000, // 请求超时
});

// 请求拦截器
service.interceptors.request.use(
    config => {
        console.log('[Axios Request] URL:', config.url);
        console.log('[Axios Request] Method:', config.method);
        console.log('[Axios Request] Params:', config.params || config.data);
        return config;
    },
    error => {
        console.error('[Axios Request Error]', error);
        return Promise.reject(error);
    }
);

// 响应拦截器
service.interceptors.response.use(
    response => {
        console.log('[Axios Response] URL:', response.config.url);
        console.log('[Axios Response] Status:', response.status);
        console.log('[Axios Response] Data:', response.data);
        return response.data; // 直接返回响应体
    },
    error => {
        console.error('[Axios Response Error]', error);
        return Promise.reject(error);
    }
);

export default service;
