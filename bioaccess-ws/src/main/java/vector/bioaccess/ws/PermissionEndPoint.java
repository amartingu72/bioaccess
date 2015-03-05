package vector.bioaccess.ws;





import javax.annotation.Resource;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import vector.bioaccess.services.PermissionDataProvider;
import vector.bioaccess.ws.auto_generated.GetEntryPermissionRequest;
import vector.bioaccess.ws.auto_generated.GetEntryPermissionResponse;


@Endpoint
public class PermissionEndPoint {
	private static final String NAMESPACE_URI = "http://vector/bioaccess/ws/auto-generated";

	@Resource(name="permissionDataProvider")
	private PermissionDataProvider permissionDataProvider;
	/*private PermissionRepository permissionRepository;

	@Autowired
	public PermissionEndPoint(PermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;
	}*/
	

	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEntryPermissionRequest")
	@ResponsePayload
	public GetEntryPermissionResponse getEntryPermission(@RequestPayload GetEntryPermissionRequest request) {
		GetEntryPermissionResponse response = new GetEntryPermissionResponse();
		response.setPermission(permissionDataProvider.hasAccess(request.getUserid(), request.getFacilityid(),request.getController()));
		return response;
	}
}
