// import axios from 'axios'
// import { login, loginInit } from "./actions/actions"


// export const register = (email, password, confirm_password) => {


//     if (password.length >= 6 && password === confirm_password && (email !== null || email !== "") && email.match(email_re)) {

//         axios.post(BASE_URL + "register", { email: email, password: password })
//             .then(res => console.log(res))
//             .catch(err => console.log(err));
//     } else {
//         console.log("Bad")
//     }
// }



// export const allpy = (first_name, middle_name, last_name, nickname, dob, gender, university, year_of_graduation, cv, street_address_line1, street_address_line2, city, region, zip_code, snnit_number, nss_number, phone_number, whatSapp_number, referral_fullname) => {

//     axios.post(BASE_URL + "applicantdata", {
//         first_name,
//         middle_name,
//         last_name,
//         nickname,
//         dob,
//         gender,
//         university,
//         year_of_graduation,
//         cv,
//         street_address_line1,
//         street_address_line2,
//         city,
//         region,
//         zip_code,
//         snnit_number,
//         nss_number,
//         phone_number,
//         whatSapp_number,
//         referral_fullname
//     })
//         .then(res => res)
//         .catch(err => console.log(err));
// }

// // export const loginUser = (email, password) => {
// //     if ((email.length > 0 && password.length >= 6) && email.match(email_re)) {
// //         axios.post(BASE_URL + "login", { email, password })
// //             .then(res => {
// //                 const { id, email, password } = res.data
// //                 localStorage.setItem("id", id)
// //                 localStorage.setItem("email", email)
// //                 localStorage.setItem("password", password)
// //                 console.log(res.data)
// //                 dispatch(login())
// //             })
// //             .catch(err => console.log(err));
// //     } else {
// //         console.log("Bad data")
// //     }


// // }


