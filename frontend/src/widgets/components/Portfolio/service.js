import { API_URL } from "./../../../config";
import axios from "axios"

export default class PortfolioService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/portfolio/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/portfolio/" + id);
    }
    
    

    static create(x)
    {
        return axios.post(API_URL + "/portfolio/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/portfolio/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/portfolio/" + id);
    }
}