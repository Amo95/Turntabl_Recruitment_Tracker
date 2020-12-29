import React, { Component } from 'react';
import { connect } from 'react-redux'

class Profile extends Component {
    state = {  }
    render() { 
        return ( 
        <div className ="profile-body">
            <div class="wrap">

                <div class="left">
                    <div className="img-size">
                        <img src="" 
                        alt="user" width="100" />
                    </div>
                    <p>Passport Photo</p>
                </div>

                <div class="right">
                    <div class="info">
                        <h3>Personal Information</h3>
                        <div class="info_data">
                            <div class="data">
                                <span>Name</span>
                                <p>Innocent Mawulorm Fiadu</p>
                            </div>
                            <div class="data">
                                <span>Known As</span>
                                <p>Schoolboy Dyerk Q</p>
                            </div>
                            <div class="data">
                                <span>Email</span>
                                <p>InnocentMawulorm@turntabl.com</p>
                            </div>
                            <div class="data">
                                <span>Phone</span>
                                <p>+233555154869</p>
                                <p>+233555154869</p>
                            </div>
                            <div class="data">
                                <span>Gender</span>
                                <p>Male</p>
                            </div>
                            <div class="data">
                                <span>D.O.B</span>
                                <p>20-06-1995</p>
                            </div>
                        </div>
                    </div>

                    <div class="info">
                        <h3>Home Address</h3>
                        <div class="info_data">
                            <div class="data">
                                <span>Address</span>
                                <p>turntabl GH Ltd, 2nd floor, Sonnidom House, Achimota, Mile 7, Accra</p>
                                <p>turntabl GH Ltd, 2nd floor, Sonnidom House, Achimota, Mile 7, Accra</p>
                            </div>
                            <div class="data">
                                <span>Town|City</span>
                                <p>Achimota</p>
                            </div>
                            <div class="data">
                                <span>State|Region</span>
                                <p>Greater Accra </p> 
                            </div>
                            <div class="data">
                                <span>Zip-Code</span>
                                <p>00233</p>
                            </div>
                        </div>
                    </div>

                    <div class="info">
                        <h3>University Details</h3>
                        <div class="info_data">
                            <div class="data">
                                <span>University Name</span>
                                <p>Ho Technical university </p>
                            </div>
                            <div class="data">
                                <span>Graduation Year</span>
                                <p>2021</p>
                            </div>
                            <div class="data">
                                <span>NSS Number</span>
                                <p>NSSGHP******* </p> 
                            </div>
                            <div class="data">
                                <span>SSNIT</span>
                                <p>C03**********</p>
                            </div>
                        </div>
                    </div>

                    <div class="info">
                        <h3>Current Employment Datails</h3>
                        <div class="info_data">
                            <div class="data">
                                <span>Company Name</span>
                                <p>TURNTABL GHANA </p>
                            </div>
                            <div class="data">
                                <span>Position</span>
                                <p>Jnr. Softwar Engineer</p>
                            </div>
                            <div class="data">
                                <span>Start Date</span>
                                <p>12-12-2019 </p> 
                            </div>
                            <div class="data">
                                <span>End Date</span>
                                <p>12-06-2020</p>
                            </div>
                        </div>
                    </div>

                    <div class="info">
                        <h3>Recommended By:</h3>
                        <div class="info_data">
                            <div class="data">
                                <span>Name</span>
                                <p> Innocent Mawulorm Fiadu </p>
                            </div>
                        </div>
                    </div>
            </div>
            </div>
        </div>
         );
    }
}
 
export default connect() (Profile);