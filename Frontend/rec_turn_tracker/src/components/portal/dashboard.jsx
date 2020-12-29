import React from "react";
import { connect } from 'react-redux';

import Applicant from "../applicant/applicantFormv2";
import Footer from "./footer";
import Navboard from "./navboard";
import Profile from "./profile";
import Bank from "./bank";
import Tracker from "./tracker"

export class Dashboard extends React.Component {
    state = { 
        panel:()=> <Profile /> 
     }

     profile = ()=> this.setState({panel: () => <Profile />});
     tracker = ()=> this.setState({panel: () => <Tracker />});
     bank = ()=> this.setState({panel: () => <Bank />});
     apply = ()=> this.setState({panel: () => <Applicant />})
    

    render () {
        return (
           
            <div className="dash">
                <div className="wrapper">
                    <div className="sidebar">
                        <h2><a href="#"><span>turn</span>tabl</a></h2>
                        <ul className="line">
                            <li className="liner">
                                <a onClick={this.profile} href="#"><i className="fa fa-user"></i>&nbsp; Profile</a>
                            </li>
                            <li className="liner">
                                <a onClick={this.apply} href="#"><i className="fa fa-address-card"></i>&nbsp; Applicant Form </a>
                            </li>
                            <li className="liner">
                                <a onClick={this.bank} href="#"><i class="fa fa-money"></i>&nbsp; Bank Details</a>
                            </li>
                            <li className="liner">
                                <a onClick={this.tracker} href="#"><i className="fa fa-map-pin"></i>&nbsp; Tracker</a>
                            </li>
                            <li className="liner">
                                <button><i class="fa fa-sign-out"></i> Logout</button>
                            </li>
                        </ul>
                    </div>
                    <div className="main_content">
                        <div className="header"> <Navboard /> </div>   
                        <div className="info">
                        {this.state.panel() }
                        <Footer />
                    </div>
                    </div>
                </div>
            </div>


        );
    }


}

export default connect()(Dashboard);