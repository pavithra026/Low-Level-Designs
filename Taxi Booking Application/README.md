<h1><b>Taxi Booking Application</b></h1><br>


<h2>LOGIN MODULE</h2>

<ol>
    <li>Initially, there will be 4 customers and 4 taxis.</li>
    <li>Customers can login/Sign-Up if they don't own an account.</li>
    <li>Taxi Drivers can login using their User ID/Taxi-Id and Password.</li>
</ol>

<p><strong>Taxi Driver Credentials:</strong></p>
<table>
    <tr>
        <th>Taxi-Id</th>
        <th>Taxi-Name</th>
        <th>Password</th>
        <th>Age</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Taxi-A</td>
        <td>111</td>
        <td>25</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Taxi-B</td>
        <td>222</td>
        <td>36</td>
    </tr>
    <tr>
        <td>3</td>
        <td>Taxi-C</td>
        <td>333</td>
        <td>31</td>
    </tr>
    <tr>
        <td>4</td>
        <td>Taxi-D</td>
        <td>444</td>
        <td>28</td>
    </tr>
</table>

<p><strong>Customer Credentials:</strong></p>
<table>
    <tr>
        <th>Cust-Id</th>
        <th>Cust-Name</th>
        <th>Password</th>
        <th>Age</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Customer-1</td>
        <td>55</td>
        <td>25</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Customer-2</td>
        <td>66</td>
        <td>36</td>
    </tr>
    <tr>
        <td>3</td>
        <td>Customer-3</td>
        <td>77</td>
        <td>31</td>
    </tr>
    <tr>
        <td>4</td>
        <td>Customer-4</td>
        <td>88</td>
        <td>28</td>
    </tr>
</table>

<h2>BOOKING MODULE</h2>

<ol>
    <li>Taxi Location Starts from 'A'</li>
    <li>Taxi FreeTime starts from 6 AM.</li>
    <li>Pick-up Location/Destination can be between ['A' - 'Z']</li>
    <li>Pick-Up Time should be in 24 Hr format i.e., 6am, 7am, ... 12pm, 13pm, ... 23pm</li>
    <li>Taxi which is nearby and has comparatively low income is allocated.</li>
    <li>After Every ride, the Taxi Live location details are displayed.</li>
</ol>

<h2>TAXI DRIVER MODULE</h2>

<ol>
    <li>Drivers can view their ride history.</li>
    <li>Ride history displays the Customer who took the ride, Pick-up location, destination, Fare, and the Company's Commission.</li>
</ol>

<h2>CUSTOMER MODULE</h2>

<ol>
    <li>Customer can view their ride history.</li>
    <li>Ride history displays Customer Name, Taxi they took, pick-up location, destination, and Fare they paid.</li>
</ol>

<h2>ZULA ADMIN</h2>

<ol>
    <li>Zula (company name) can view all the customers' ride history as well as all the taxi's ride history and live location.</li>
</ol>
