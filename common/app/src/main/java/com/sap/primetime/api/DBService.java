package com.sap.primetime.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sap.primetime.dao.FileDAO;
import com.sap.primetime.dao.PageDAO;
import com.sap.primetime.dao.PlaylistDAO;
import com.sap.primetime.dao.ScreenDAO;
import com.sap.primetime.dao.UserDAO;
import com.sap.primetime.dao.entities.File;
import com.sap.primetime.dao.entities.Page;
import com.sap.primetime.dao.entities.Playlist;
import com.sap.primetime.dao.entities.Screen;
import com.sap.primetime.dao.entities.User;

@Path("/dbservice")
public class DBService extends BasicService {
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		if (!isDBAdmin()) {
			throwUnauthorized();
		}

		return new UserDAO().getAllDesc("dateModified", false);
	}

	@GET
	@Path("/pages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Page> getPages() {
		if (!isDBAdmin()) {
			throwUnauthorized();
		}

		return new PageDAO().getAll("name");
	}

	@GET
	@Path("/files")
	@Produces(MediaType.APPLICATION_JSON)
	public List<File> getFiles() {
		if (!isDBAdmin()) {
			throwUnauthorized();
		}

		return new FileDAO().getAll("name");
	}

	@GET
	@Path("/playlists")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Playlist> getPlaylists() {
		if (!isDBAdmin()) {
			throwUnauthorized();
		}

		return new PlaylistDAO().getAll("name");
	}

	@GET
	@Path("/screens")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Screen> getScreens() {
		if (!isDBAdmin()) {
			throwUnauthorized();
		}

		return new ScreenDAO().getAll("name");
	}

}
