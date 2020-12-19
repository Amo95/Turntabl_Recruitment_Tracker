import React from "react";
import "./App.scss";
import { BrowserRouter as Router, Route, Switch, Link, Redirect } from "react-router-dom";
import Toggle from "./components/admin/Toggle";
import Update_Password from "./components/admin/update_password";

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
        
      {/* <toggle /> */}
      <Route path="/" component={Toggle} exact={true}/>
      <Route path="/update" component={Update_Password} exact={true}/>
      </ Router>
    )
    
  }
}

export default App;
