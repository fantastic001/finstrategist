import { API_URL } from "./../../../config";
import axios from "axios"

export default class ConfigParamService 
{
    constructor(self) 
    {
        this.self = self;
    }


    static submit(name, x)
    {
        return axios.post(API_URL + "/config/" + name, x, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
    }

    static get(name)
    {
        return axios.get(API_URL + "/config/" + name);
    }
}