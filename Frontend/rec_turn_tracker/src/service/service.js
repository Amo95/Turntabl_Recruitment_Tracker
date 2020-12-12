import axios from 'axios'


const BASE_URL = "http://localhost:8080/api/turntablexe/";

const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

export const register = (email, password, confirm_password) => {


    if (password.length >= 6 && password === confirm_password && (email !== null || email !== "") && email.match(re)) {

        axios.post(BASE_URL + "register", { email, password })
            .then(res => console.log(res))
            .catch(err => console.log(err));
    } else {
        console.log("Fields can't be empty")
    }

}