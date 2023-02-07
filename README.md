# property-service

REST APIs for Property Management System

# Features

# 1. Admin

.	The admin should have a dashboard page

.	If the owner registers to the web site, he/she need to get approval from Admin in order to post properties.

# 2. Owner

.	Register as Owner

.	Property (CRUD). If a property is under ‘pending’ it cannot be deleted

.	Owner cannot submit offers on property from the website

.	Maintain offers:

a.	Reject offer if the owner does not accept. The property status should remain ‘available’

b.	If ‘pending’ phase get accepted from both sides. The property status becomes ‘contingent’.

c.	Receive messages from a customer (General inquires NOT an offer)

d.	Cancel contingency

e.	Maintain offers placed (list of placed offers)

# 3. Customer

a.	Register as Customer

b.	Cannot offer properties on this website

c.	Check offer History

d.	Maintain current offers placed

e.	Cannot cancel offer after ‘contingency’

f.	Place offer, the property status will be changed to ‘pending’ if the offer gets accepted



