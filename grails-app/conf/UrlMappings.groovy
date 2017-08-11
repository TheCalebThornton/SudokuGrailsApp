class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/rest/myAction" (controller: "puzzleController", action: "save", parseRequest: true)

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
