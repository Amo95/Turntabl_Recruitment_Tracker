import React from "react";
import { BrowserRouter as Router, Route, Redirect, Switch } from "react-router-dom";
import { connect } from 'react-redux'

import "./App.scss";
import 'antd/dist/antd.css';

import Togle from "./components/applicant/Togle";
import ForgotPassword from "./components/applicant/forgotPassword";
import Applicant from "./components/applicant/applicantFormv2";
import Dashboard from "./components/portal/dashboard";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {

    return (
      <Router>
        <Switch>
          <Route path="/" component={Togle} exact={true} />
          <Route path="/recover" component={ForgotPassword} strict exact={true} />
          <Route path="/applyv2" component={Applicant} exact={true} />
          {/* {this.props.login_stat || localStorage.getItem("isLogedIn") ? <Route path="/applyv2" component={Applicant} strict exact={true} /> : <Redirect to="/" />} */}
          {/* <Route path="/apply" component = {ApplicationForm} strict exact = {true} /> */}
        </Switch>
        <Route path="/dashboard" component = {Dashboard} strict exact = {true} /> 
      </ Router>
    )

  }
}

const mapStateToProps = state => ({
  uId: state.isLogin.id,
  uEmail: state.isLogin.email,
  login_stat: state.isLogin.login_status
});


export default connect(mapStateToProps)(App);
