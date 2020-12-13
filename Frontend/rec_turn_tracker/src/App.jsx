import React from "react";
import "./App.scss";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Togle from "./components/applicant/Togle";
import ForgotPassword from "./components/applicant/forgotPassword";
import ApplicationForm from "./components/applicant/applicantForm";
import Applicant from "./components/applicant/applicantFormv2";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isLogginActive: true
    };
  }


  render() {

    return (

      <Router>

        {/* <Togle /> */}
        <Route path="/" component={Togle} exact={true} />
        <Route path="/recover" component={ForgotPassword} strict exact={true} />
        <Route path="/apply" component={ApplicationForm} strict exact={true} />
        <Route path="/applyv2" component={Applicant} strict exact={true} />
      </ Router>
    )

  }
}

export default App;
