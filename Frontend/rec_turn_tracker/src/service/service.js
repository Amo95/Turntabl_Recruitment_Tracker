import axios from 'axios'


const BASE_URL = "http://localhost:8080/api/turntablexe/";

const email_re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

export const register = (email, password, confirm_password) => {


    if (password.length >= 6 && password === confirm_password && (email !== null || email !== "") && email.match(email_re)) {

        axios.post(BASE_URL + "register", { email, password })
            .then(res => console.log(res))
            .catch(err => console.log(err));
    } else {
        console.log("Bad")
    }
}



export const allpy = (first_name, middle_name, last_name, nickname, dob, gender, university, year_of_graduation, cv, street_address_line1, street_address_line2, city, region, zip_code, snnit_number, nss_number, phone_number, whatSapp_number, referral_fullname) => {

    axios.post(BASE_URL + "applicantdata", {
        first_name,
        middle_name,
        last_name,
        nickname,
        dob,
        gender,
        university,
        year_of_graduation,
        cv,
        street_address_line1,
        street_address_line2,
        city,
        region,
        zip_code,
        snnit_number,
        nss_number,
        phone_number,
        whatSapp_number,
        referral_fullname
    })
        .then(res => console.log(res))
        .catch(err => console.log(err));
}
