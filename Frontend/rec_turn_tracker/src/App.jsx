import React from "react";
import "./App.scss";
import { BrowserRouter as Router, Route, Switch, Link, Redirect } from "react-router-dom";
import Togle from "./components/applicant/Togle";
import ForgotPassword from "./components/applicant/forgotPassword";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isLogginActive: true
    };
  }


  render() {
   
    return(
      
      <Router>
        <Route path="/" component={Togle} exact={true}/>
        <Route path = "/recover" component = {ForgotPassword} exact = {true} strict />
      </Router>
    )
    
  }
}

export default App;
