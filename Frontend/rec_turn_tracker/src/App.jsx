import React from "react";
import "./App.scss";
import 'antd/dist/antd.css';
import { BrowserRouter as Router, Route, Redirect, Switch } from "react-router-dom";
import Togle from "./components/applicant/Togle";
import ForgotPassword from "./components/applicant/forgotPassword";
import Applicant from "./components/applicant/applicantFormv2";
import { connect } from 'react-redux'




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
          {this.props.login_stat || localStorage.getItem("isLogedIn") ? <Route path="/applyv2" component={Applicant} strict exact={true} /> : <Redirect to="/" />}
        </Switch>
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
