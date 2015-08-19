# vaadin-with-plain-undertow

An really trimmed down undertow+vaadin server. Starts in 
matter of milliseconds, weights aroung 5 megs. This is 
not how you should generally build your web apps, but 
might be a suitable base for some really low resource 
servers in e.g. IoT solutions. Vaadin add-on usage 
supported, but relies on cdn.virit.in, so users must 
always have internet connection (the actual server 
still don't). 
