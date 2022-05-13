<style>
            haiku-burger{
                width:3em;
                height:3em;
            }
            #navbar.open{
                display:flex;
            }
        </style>
    <nav>
        <ul  id="navbar" class="hide-sm list centred row" >
            <li>
                <a class="nav-item centred" href="login">Login</a>
            </li>
        </ul>
        <div class="list centred row" >
            <haiku-light class="nav-item centred" >Test</haiku-light>
            <haiku-burger class="hide-lg centred" menu="navbar" style="height: 3em;width: 3em;--dark: #333;"></haiku-burger>
        </div>
    </nav>