# kotlin-news

## features
### build code native
- precisa do graal vm na maquin
- tem o script para build
- para maiores detalhes https://www.baeldung.com/spring-native-intro
- para gerar a imagem da app native, possui a configuracao abaixo no pom mavem
```
				<plugin>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-maven-plugin</artifactId>
					<configuration>
						<image>
							<builder>paketobuildpacks/builder:tiny</builder>
							<env>
								<BP_NATIVE_IMAGE>true</BP_NATIVE_IMAGE>
							</env>
						</image>
					</configuration>
				</plugin>
```

### expose jdbc kotlin
- orm em kotlin para spring, com suporte a co code native