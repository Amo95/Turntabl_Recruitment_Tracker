import axios from 'axios'


const BASE_URL = "http://localhost:8080/api/turntablexe/"

export const getApplicantdata = () => {
    return axios.get(BASE_URL + "applicants")
        .then(res => res.data)
        .catch(err => console.log(err))
}