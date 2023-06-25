import request from '../utils/request';

export const fetchData = () => {
    return request({
        url: 'http://localhost:5273/all',
        method: 'get'
    });
};
