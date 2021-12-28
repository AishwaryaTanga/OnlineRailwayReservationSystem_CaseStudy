import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Switch , Link, Route,} from "react-router-dom";



import Home from "./components/Home";
import TrainList from "./components/TrainList";
import TicketBooking from "./components/TicketBooking";
import createTrain from './components/createTrain';
import deleteTrain from "./components/deleteTrain";
import adminSignIn from "./components/adminSignIn";
import SignUp from "./components/SignUp";
import Login from "./components/Login";
import PaymentMethod from "./components/PaymentMethod";
import PaytmPG from "./components/PaytmPG";
import adminProfile from "./components/adminProfile";
import SBIBankPG from "./components/SBIBankPG";
import ThankYouMessage from "./components/ThankYouMessage";
import UpdateTrain from "./components/UpdateTrain";




function App() {
  return (
    <Router>
      <div className="navImage">
       <h1 style={{textAlign:'center'}}>
             ONLINE RAILWAY RESERVATION SYSTEM
        </h1>
        </div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark" >
        <div className="collapse navbar-collapse" style={{marginLeft:370}}>
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link to="/" className="nav-link" style={{ color: "white" }}>
                Home
              </Link>
            </li>
          </ul>
        </div>
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link
                to="/trainlist"
                className="nav-link"
                style={{ color: "white" }}
              >
                Train List
              </Link>
            </li>
          </ul>
        </div>
        
       
      
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link
                to="/adminSignIn"
                className="nav-link"
                style={{ color: "white" }}
              >
                Admin
              </Link>
            </li>
          </ul>
        </div>
      </nav>

      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/trainlist" exact component={TrainList} />
        <Route path="/booking" exact component={TicketBooking} />
        <Route path="/signUp" exact component={SignUp} />
        <Route path="/login" exact component={Login} />
        <Route path="/payment" exact component={PaymentMethod} />
        <Route path="/submitPaymentDetail" exact component={PaytmPG} />
        <Route path="/adminSignIn" exact component={adminSignIn} />
        <Route path="/addTrain" exact component={createTrain} />
        <Route path="/delTrain" exact component={deleteTrain} />
        <Route path="/adminprofile" exact component={adminProfile} />
        <Route path="/sbipg" exact component={SBIBankPG} />
        <Route path="/thankyou" exact component={ThankYouMessage} />
        <Route path="/updateTrain" exact component={UpdateTrain }/>
        
        
        
      
      </Switch>
      
       
      <div
        className="footer"       
        style={{ backgroundColor: "black", height: 60 }}
      >
        <center>
          {" "}
          <div>
            <p style={{color:'white',paddingTop:15}}>
            &copy;2021 aishwarya tanga.com
            </p>
         
          </div>{" "}
          <div style={{ color: "white" }}></div>
        </center>
      </div>
    </Router>
  );
}

export default App;
