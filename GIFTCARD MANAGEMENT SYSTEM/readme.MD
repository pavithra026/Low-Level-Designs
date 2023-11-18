<b><h1>Giftcard Management System</h1></b><br>

<h3>Design a simple Gift Card Management System which you can gift to any one to make Purchase</h3>

<p> Three customer account details pre-defined </p>

<table border="1">
    <tr>
        <th>CustId</th>
        <th>Acc No</th>
        <th>Name</th>
        <th>Balance</th>
        <th>Encrypted Password</th>
    </tr>
    <tr>
        <td>11</td>
        <td>11011</td>
        <td>Kumar</td>
        <td>10000</td>
        <td>ApipNbjm --> ZohoMail(decrypt pass)</td>
    </tr>
    <tr>
        <td>22</td>
        <td>22022</td>
        <td>Madhu</td>
        <td>20000</td>
        <td>Cboljoh --> Banking(decrypt pass)</td>
    </tr>
    <tr>
        <td>33</td>
        <td>33033</td>
        <td>Robin</td>
        <td>30000</td>
        <td>kbwb22 --> java11(decrypt pass)</td>
    </tr>
</table>

<b> create a banking system where </b>
<ol>
  <li> Account Login</li>
  <li> Purchase </li>
</ol>

<b><h5> 1. Account Login </h5></b>
<p> Now Login to your account and enter your Customer Id And Password
     
     Password encryption : 0->1,1->2,2->3......9->0  || a->b,b->c......z->a   || A>B,B->C......Z->A
</p>
<p>1.Create new Gift Card
     2.Top up existing Gift Card
     3.Show Gift Card Transactions
     4.Block a existing Gift Card
     5.Logout
     
     
     1.Create new Gift Card
     now generate a gift card with 5 digits and its pin of four digits --> should be able to create N number of Gift cards as poosible
     
     2.Top up existing Gift Card
     top up existing card using the balance in your account
     
     3.Show Gift Card Transactions
     print all available Gift card Transactions
     (Like credit ,debit, balance )
     
     4.Block a existing Gift Card
     block the card and return back the amount to the account
     
     5. Logout
 
2.Purchase

    Get Gift Card Id
    Get Gift Card Pin
    Get Bill Amount
   
    Deduct the bill amount from the gift card and updtae the balance in the gift card
   
    if Bill amount is greater than Rs.100
    add a reward point to the gift card and redeem the amount to balance if reward points is 10 ( 1 reward point is 1 rupee )
</p>


