import request from '../utils/request';

export const fetchData = () => {
    return request({
        url: 'http://localhost:5273/table.json',
        method: 'get'
    });
};
